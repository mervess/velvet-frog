# Velvet Frog

![Velvet Frog](https://images.unsplash.com/photo-1502403421222-2ae1f0a65fe2?ixlib=rb-1.2.1&auto=format&fit=crop&w=1358&q=80)
*Photo by [David Clode](https://unsplash.com/@davidclode) on [Unsplash](https://unsplash.com/)*

_Velvet Frog_ was an experimental linear algebra library written in pure Java. The project is lastly updated roughly a year ago, and it's unfinished. It was meant to be used for research purposes such as profiling in the compiler level and acceleration via GPUs for computer vision algorithms. Therefore, you will see that it's hard-coded in many functions, and only 1D arrays were used in.

## Setup
It was built on Eclipse-IDE and written in Java-8.
You might need [Jama](https://math.nist.gov/javanumerics/jama/) version 1.0.3 to use some functions e.g. inverting a 7x7 matrix. 

## Usage
Have a look at the basic usage examples in [GeneralTester.java](https://github.com/mervess/velvet-frog/blob/master/VelvetFrog/src/test/GeneralTester.java), and the _JUnit_ test file [Vector2fTest.java](https://github.com/mervess/velvet-frog/blob/master/VelvetFrog/src/vector/Vector2fTest.java).
