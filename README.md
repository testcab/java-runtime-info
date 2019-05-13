# java-runtime-info

[![docker build automated](https://img.shields.io/docker/cloud/automated/testcab/java-runtime-info.svg)](https://hub.docker.com/r/testcab/java-runtime-info "testcab/java-runtime-info")

This is a docker image intended to print out [available processors][availableProcessors] and [max memory][maxMemory] of java runtime, in order to visualize cpu/memory requests/limits specified on pod in kubernetes.

[availableProcessors]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Runtime.html#availableProcessors()
[maxMemory]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Runtime.html#maxMemory()


## Test Results

Tested with docker image [openjdk:8-jre](https://hub.docker.com/_/openjdk/) on a kubernetes cluster of 3 VMs with 16 vCPU and 32 GiB memory. Memory request and limit are not set. Test files can be found under `tests` directory.

| CPU Request | CPU Limit | = | Available Processors | Max Memory |
| ----------: | --------: | - | -------------------: | ---------: |
|  0 / (none) |    (none) | = |                    1 | 8151564288 |
|        500m |    (none) | = |                    1 | 8151564288 |
|           1 |    (none) | = |               **16** | 7495745536 |
|       1500m |    (none) | = |                    2 | 7495745536 |
|           2 |    (none) | = |                    2 | 7495745536 |
|        500m |      800m | = |                    1 | 8151564288 |
|        500m |         1 | = |                    1 | 8151564288 |
|           1 |         2 | = |                    2 | 7495745536 |
|           1 |     3500m | = |                    4 | 7495745536 |
|       1500m |     3500m | = |                    4 | 7495745536 |


Conclusions:

* If CPU limit is specified, available processors are set to the ceiling of CPU limit;
* If CPU request is specified but limit unspecified, available processors are set to the ceiling of CPU request with the following exception:
* If CPU request is set to 1, available processors are set to the number of CPU cores of the underlying VM.


## LICENSE

[MIT](LICENSE)
