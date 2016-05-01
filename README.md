# PostmanProblem
Post Office Problem (IOI 2000)

There is a straight highway with villages alongside the highway. The highway is represented as an integer axis, and the position of each village is identiﬁed with a single integer coordinate. There are no two villages in the same position. The distance between two positions is the absolute value of the difference of their integer coordinates. Post ofﬁces will be built in some, but not necessarily all of the villages. Obviously, a village and the post ofﬁce in it have the same position. For building the post ofﬁces, their positions should be chosen so that the total sum of all distances between each village and its nearest post ofﬁce is minimal.

Given the positions of the villages and the number of police ofﬁces, this program computes the least possible sum of all distances between each village and its nearest post ofﬁce.

 Each input case contains two lines: the ﬁrst line contains two integers: the number of villages V ∈ [1,300] and the number of post office P ∈ [1,30],P ≤ V separated by a blank space. The second line contains V integers in increasing order. These V integers are the positions of the villages. For each position X it holds that 1 ≤ X ≤ 10,000.

