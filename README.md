# n-queens, no three in line

This is a test assignment. The original task is:
> Place N queens on an NxN chess board so that none of them attack each other (the classic n-queens problem). Additionally, please make sure that no three queens are in a straight line at ANY angle, so queens on A1, C2 and E3, despite not attacking each other, form a straight line at some angle. Use this as a vehicle to demonstrate your knowledge, and with your reply, tell us what you chose to demonstrate.

The solution is a command line util which accepts 1 argument N - board size which matches number of pieces(queens) to place.
The util prints result to standard output in algebraic notation (chess), generalized for boards bigger than 26x26(26 = z, 27 = ba...).
If no solution found, the util prints message "No solution found." to standard output.    


Implementation details: 
* implements backtracking algorithm.
* single thread, mutly-threading did not give consistent performance improvement
* memory consumption: so far was running ok with default java settings
* performance on i7-8568U: N in [0..21] - under a minute, [22..31) and (31..35] - under 10 minutes, [32] - under 40 minutes.
* theoretical algorithm complexity estimation: time - O(N!), memory - O(N).       

See class com.nqueens.App for entry point.

Command line example of run using gradle: 

`gradle run --args="8"`


![Java CI with Gradle](https://github.com/vmakieienko/nqueens/workflows/Java%20CI%20with%20Gradle/badge.svg)