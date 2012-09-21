This is a small project to evaluate matrix multiplication performance
with various implementations. The benchmarks are created with [Google Caliper](http://code.google.com/p/caliper/).

* Reference implementation: [Jama](http://math.nist.gov/javanumerics/jama/)
* Mutable ForkJoin implementation with [Java 7 Fork Join Framework](http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html)

coming soon...

* Immutable ForkJoin
* Scala with par collections
* Scala Akka implementation

## Jama Benchmark

  m1   n2   nm memoryMax      us linear runtime
 100  100   10  -Xmx512M      153 =
 100  100   10 -Xmx1024M      151 =
 100  100   10 -Xmx2048M      139 =
 100  100  100  -Xmx512M    1.357 =
 100  100  100 -Xmx1024M    1.347 =
 100  100  100 -Xmx2048M    1.351 =
 100  100 1000  -Xmx512M   14.273 =
 100  100 1000 -Xmx1024M   14.320 =
 100  100 1000 -Xmx2048M   14.507 =
 100 1000   10  -Xmx512M    1.550 =
 100 1000   10 -Xmx1024M    1.587 =
 100 1000   10 -Xmx2048M    1.506 =
 100 1000  100  -Xmx512M   13.552 =
 100 1000  100 -Xmx1024M   13.639 =
 100 1000  100 -Xmx2048M   13.356 =
 100 1000 1000  -Xmx512M  158.848 ==
 100 1000 1000 -Xmx1024M  158.569 ==
 100 1000 1000 -Xmx2048M  158.241 ==
1000  100   10  -Xmx512M    2.000 =
1000  100   10 -Xmx1024M    1.992 =
1000  100   10 -Xmx2048M    1.893 =
1000  100  100  -Xmx512M   14.344 =
1000  100  100 -Xmx1024M   14.585 =
1000  100  100 -Xmx2048M   14.266 =
1000  100 1000  -Xmx512M  183.863 ==
1000  100 1000 -Xmx1024M  183.126 ==
1000  100 1000 -Xmx2048M  178.623 ==
1000 1000   10  -Xmx512M   33.562 =
1000 1000   10 -Xmx1024M   33.936 =
1000 1000   10 -Xmx2048M   32.467 =
1000 1000  100  -Xmx512M  159.944 ==
1000 1000  100 -Xmx1024M  157.129 ==
1000 1000  100 -Xmx2048M  156.704 ==
1000 1000 1000  -Xmx512M 1.855.838 ==============================
1000 1000 1000 -Xmx1024M 1.836.510 =============================
1000 1000 1000 -Xmx2048M 1.818.988 =============================

vm: java
trial: 0
benchmark: Jama

## Fork Join naive and mutable implementation Benchmark

  n2   nm   m1 memoryMax      us linear runtime
 100   10  100  -Xmx512M    1.370 =
 100   10  100 -Xmx1024M      749 =
 100   10  100 -Xmx2048M    1.198 =
 100   10 1000  -Xmx512M    3.093 =
 100   10 1000 -Xmx1024M    2.297 =
 100   10 1000 -Xmx2048M    2.385 =
 100  100  100  -Xmx512M    1.766 =
 100  100  100 -Xmx1024M    1.834 =
 100  100  100 -Xmx2048M    3.100 =
 100  100 1000  -Xmx512M    7.802 =
 100  100 1000 -Xmx1024M    8.213 =
 100  100 1000 -Xmx2048M    7.730 =
 100 1000  100  -Xmx512M   26.510 =
 100 1000  100 -Xmx1024M   22.346 =
 100 1000  100 -Xmx2048M   19.393 =
 100 1000 1000  -Xmx512M  216.503 =
 100 1000 1000 -Xmx1024M  190.910 =
 100 1000 1000 -Xmx2048M  184.261 =
1000   10  100  -Xmx512M    2.426 =
1000   10  100 -Xmx1024M    1.982 =
1000   10  100 -Xmx2048M    2.231 =
1000   10 1000  -Xmx512M   10.309 =
1000   10 1000 -Xmx1024M   10.939 =
1000   10 1000 -Xmx2048M   11.420 =
1000  100  100  -Xmx512M   11.137 =
1000  100  100 -Xmx1024M   12.200 =
1000  100  100 -Xmx2048M   10.662 =
1000  100 1000  -Xmx512M  119.942 =
1000  100 1000 -Xmx1024M   93.003 =
1000  100 1000 -Xmx2048M   82.721 =
1000 1000  100  -Xmx512M  662.475 ==
1000 1000  100 -Xmx1024M  645.997 ==
1000 1000  100 -Xmx2048M  589.020 ==
1000 1000 1000  -Xmx512M 6.734.155 ==============================
1000 1000 1000 -Xmx1024M 5.835.394 =========================
1000 1000 1000 -Xmx2048M 5.463.175 ========================

vm: java
trial: 0
benchmark: MutableForkJoin


## Google Caliper

Caliper is a microbenchmark framework which overs good support if you want to test such
small things like one operation. Best way to get started is reading [these examples](http://code.google.com/p/caliper/source/browse/examples/src/main/java/examples/).

Caliper however is a microbenchmark framework which is used to test methods which take very short
time. This means with Caliper I'm not able to run longer benchmarks.

## Databene ContiPerf

[ContiPerf2](http://databene.org/contiperf) integrates very well with JUnitTests. However it has
no JVM warm-up. 

## JUnitBenchmarks

[JUnitBenchmarks](http://labs.carrotsearch.com/junit-benchmarks.html) integrates very well with JUnitTests.

## Scalatest

To ensure the implementations are correct I implemented some UnitTests with [ScalaTest](http://www.scalatest.org/),
which check against the Jama implementation.