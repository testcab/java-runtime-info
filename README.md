# java-runtime-info

[![docker build automated](https://img.shields.io/docker/cloud/automated/testcab/java-runtime-info.svg)](https://hub.docker.com/r/testcab/java-runtime-info "testcab/java-runtime-info")

This is a docker image intended to print out [available processors][availableProcessors] and [max memory][maxMemory] of java runtime, in order to visualize cpu/memory requests/limits specified on pod in kubernetes.

[availableProcessors]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Runtime.html#availableProcessors()
[maxMemory]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Runtime.html#maxMemory()


## LICENSE

[MIT](LICENSE)
