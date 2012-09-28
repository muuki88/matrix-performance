This is a small project to evaluate matrix multiplication performance
with various implementations. The benchmarks are created with [Google Caliper](http://code.google.com/p/caliper/).

* Reference implementation: [Jama](http://math.nist.gov/javanumerics/jama/)
* Reference implementation: [Colt](http://acs.lbl.gov/software/colt/)
* Mutable ForkJoin implementation with [Java 7 Fork Join Framework](http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html)

coming soon...

* Immutable ForkJoin
* Scala with par collections
* Scala Akka implementation

## Jama Benchmark

### Google Caliper Results 

```bash

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
```

### JUnitBenchmark Results

```bash

TestBenchmarkJama.testSmallelst: [measured 20 out of 30 rounds, threads: 1 (sequential)]
 round: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 0, GC.time: 0.00, time.total: 0.11, time.warmup: 0.06, time.bench: 0.05
TestBenchmarkJama.testSmall: [measured 10 out of 12 rounds, threads: 1 (sequential)]
 round: 0.21 [+- 0.02], round.gc: 0.00 [+- 0.00], GC.calls: 3, GC.time: 0.03, time.total: 2.52, time.warmup: 0.45, time.bench: 2.07
TestBenchmarkJama.testNormal: [measured 5 out of 5 rounds, threads: 1 (sequential)]
 round: 1.84 [+- 0.06], round.gc: 0.00 [+- 0.00], GC.calls: 3, GC.time: 0.05, time.total: 9.22, time.warmup: 0.00, time.bench: 9.22
```

## Colt Benchmark

### Google Caliper Results 

```bash

  m1   n2   nm memoryMax      us linear runtime
 100  100   10  -Xmx512M     165 =
 100  100   10 -Xmx1024M     166 =
 100  100   10 -Xmx2048M     164 =
 100  100  100  -Xmx512M    1.484 =
 100  100  100 -Xmx1024M    1.481 =
 100  100  100 -Xmx2048M    1.596 =
 100  100 1000  -Xmx512M   16.522 =
 100  100 1000 -Xmx1024M   14.566 =
 100  100 1000 -Xmx2048M   15.450 =
 100 1000   10  -Xmx512M    1.828 =
 100 1000   10 -Xmx1024M    1.747 =
 100 1000   10 -Xmx2048M    1.790 =
 100 1000  100  -Xmx512M   14.978 =
 100 1000  100 -Xmx1024M   16.461 =
 100 1000  100 -Xmx2048M   14.871 =
 100 1000 1000  -Xmx512M  180.866 ==
 100 1000 1000 -Xmx1024M  186.779 ==
 100 1000 1000 -Xmx2048M  169.734 ==
1000  100   10  -Xmx512M    2.233 =
1000  100   10 -Xmx1024M    2.219 =
1000  100   10 -Xmx2048M    2.388 =
1000  100  100  -Xmx512M   15.591 =
1000  100  100 -Xmx1024M   15.660 =
1000  100  100 -Xmx2048M   17.051 =
1000  100 1000  -Xmx512M  206.732 ==
1000  100 1000 -Xmx1024M  194.999 ==
1000  100 1000 -Xmx2048M  202.229 ==
1000 1000   10  -Xmx512M   37.404 =
1000 1000   10 -Xmx1024M   36.183 =
1000 1000   10 -Xmx2048M   35.958 =
1000 1000  100  -Xmx512M  177.610 ==
1000 1000  100 -Xmx1024M  173.825 ==
1000 1000  100 -Xmx2048M  175.074 ==
1000 1000 1000  -Xmx512M 1.916.253 =========================
1000 1000 1000 -Xmx1024M 2.219.389 ==============================
1000 1000 1000 -Xmx2048M 1.945.212 ==========================

vm: java
trial: 0
benchmark: Colt
```

### JUnitBenchmark Results

```bash

TestBenchmarkColt.testSmallelst: [measured 20 out of 30 rounds, threads: 1 (sequential)]
 round: 0.01 [+- 0.01], round.gc: 0.00 [+- 0.00], GC.calls: 0, GC.time: 0.00, time.total: 0.22, time.warmup: 0.14, time.bench: 0.08
TestBenchmarkColt.testSmall: [measured 10 out of 12 rounds, threads: 1 (sequential)]
 round: 0.38 [+- 0.01], round.gc: 0.00 [+- 0.00], GC.calls: 3, GC.time: 0.02, time.total: 4.65, time.warmup: 0.83, time.bench: 3.82
TestBenchmarkColt.testNormal: [measured 5 out of 5 rounds, threads: 1 (sequential)]
 round: 11.62 [+- 0.13], round.gc: 0.00 [+- 0.00], GC.calls: 4, GC.time: 0.08, time.total: 58.12, time.warmup: 0.00, time.bench: 58.12
```

## Fork Join naive and mutable implementation Benchmark

```bash

TestBenchmarkJama.testSmallelst: [measured 20 out of 30 rounds, threads: 1 (sequential)]
 round: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 0, GC.time: 0.00, time.total: 0.09, time.warmup: 0.05, time.bench: 0.04
TestBenchmarkJama.testSmall: [measured 10 out of 12 rounds, threads: 1 (sequential)]
 round: 0.19 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 3, GC.time: 0.02, time.total: 2.22, time.warmup: 0.37, time.bench: 1.85
TestBenchmarkJama.testNormal: [measured 5 out of 5 rounds, threads: 1 (sequential)]
 round: 1.86 [+- 0.07], round.gc: 0.00 [+- 0.00], GC.calls: 3, GC.time: 0.04, time.total: 9.32, time.warmup: 0.00, time.bench: 9.32
```

### Google Caliper Results 

```bash

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
```

### JUnitBenchmark Results

```bash
TestBenchmarkMutableForkJoin.testSmall: [measured 10 out of 12 rounds, threads: 1 (sequential)]
 round: 0.20 [+- 0.09], round.gc: 0.00 [+- 0.00], GC.calls: 2, GC.time: 0.02, time.total: 2.42, time.warmup: 0.40, time.bench: 2.01
TestBenchmarkMutableForkJoin.testNormal: [measured 5 out of 5 rounds, threads: 1 (sequential)]
 round: 6.01 [+- 0.53], round.gc: 0.00 [+- 0.00], GC.calls: 1, GC.time: 0.02, time.total: 30.07, time.warmup: 0.00, time.bench: 30.07
TestBenchmarkMutableForkJoin.testSmallelst: [measured 20 out of 30 rounds, threads: 1 (sequential)]
 round: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 1, GC.time: 0.01, time.total: 0.14, time.warmup: 0.06, time.bench: 0.08

```

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
