# Demo Script

## K8s demos

### Build

 * `mvn -f very-important-app/ package`
 * `docker run -e "env.pod.name=docker" -p8080:8080 fbiville/hello-app`
 * `curl -w'\n' 'http://localhost:8080/hello?who=Pivotal%20Paris'`

### Deploy to K8s

In one terminal:

```
 $ kubectl config use-context docker-desktop
 $ watch kubectl get pod,deployment,service
```

#### Pod

In another terminal:
```
 $ kubectl apply -f k8s/pod.yml
```

Then, let's cheat:
```
 # paste value
 $ kubectl get pod/hello-app-pod -o json | jq -r '.status.podIP'
 $ kubectl run -i --tty curl --image=tutum/curl --restart=Never -- bash -il
 $ curl -w '\n' http://IP:8080/hello?who=Pivotal%20Paris
```
Let's clean up:
```
 $ kubectl delete pod --all
```

#### Service

We need services instead!
(Note: NodePort assigns a pseudo-IP as cluster IP, not usable).

```
 $ kubectl apply -f k8s
 $ curl -w'\n' 'http://localhost:30808/hello?who=Pivotal%20Paris'
```
```
Let's clean up:
```
 $ kubectl delete pod --all
 $ kubectl delete service/hello-app-service
```

#### Deployment

Just showing off ReplicaSet capabilities here:

```
$ kubectl apply -f deployment.yml
$ kubectl apply -f service.yml
```

Let's run a few:
```
$ curl -w'\n' 'http://localhost:30808/hello?who=Pivotal%20Paris'
```

Let's remove a pod
```
$ kubectl delete pod/hello-app-deployment-...
```

Let's scale up:
```
$ kubectl scale --replicas=7 deployment.extensions/hello-app-deployment
```

Let's scale down:
```
$ kubectl scale --replicas=2 deployment.extensions/hello-app-deployment
```