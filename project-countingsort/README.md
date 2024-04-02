# CompSt 751 Group Project

## Name

Please put your current or desired project name here.

Improving counting sort algorithm via data locality

## People

Please list all the team members with name, github username and email,e.g. 
John Boyland, @boyland, boyland@uwm.edu

Gayatri Buchupalli, @GayatriBuchupalli, buchupa2@uwm.edu
Sushma Karri, @Sushmakarri, karris@uwm.edu
Anutejaswi Sunkara, @anutejaswisunkara, asunkara@uwm.edu

## Paper

Give the URL to the ACM digital library for the paper you will be replicating.

https://dl.acm.org/doi/abs/10.1145/3476883.3520203

### Scope

Describe what you will be implementing.

## Step 1: Implement Cache complexity of Counting Sort

----
Create a Counting Sort Function:

Input: An array arr of integers and its size n.

Find the maximum value in the array to determine the range.
Create an array count with size equal to the maximum value plus one, initialized to zero.

Iterate through arr, and for each element arr[i], increment count[arr[i]].

Perform a cumulative sum on the count array.

Create an output array output. Iterate backward through arr, place each element in its correct position in output, and decrement the respective count value.

Copy the sorted elements back into the original array

Step 2: Modify Quicksort for Preprocessing
------
Create a Modified Quicksort Function:

Input: An array arr, low index low, high index high, and a threshold value threshold.

Base Case: If the size of the current partition (high - low) is less than the threshold, return.

Partition the array around a pivot (you can use the Lomuto or Hoare partition scheme). This step rearranges the elements, with those less than the pivot on the left and those greater on the right.

Recursively apply the modified quicksort to the partitions created on either side of the pivot.

## Step 3: Implement the Hybrid Sort
Create a Hybrid Sort Function:

Input: An array arr and a threshold value.

Apply the modified quicksort to arr.

Once the array is preprocessed (partitioned), apply counting sort to the entire array.

## Step 4: Combine Everything
Combine the Methods in Your Main Function:
Initialize your array.
Call the hybrid sort function with the array and an appropriate threshold.


### Artifacts found

Give URLs of code provided by the authors of the paper or their collaborators.

https://cs.fit.edu/~pkc/classes/writing/samples/bentley93engineering.pdf
## Plan

### Main classes

What classes will you implement to demonstrate the technique of the paper?

CountingSort.java, HybridSort.java, QuickSort.java, Main.java, TestEfficiency.java, TestHybridSort.java

### Helper classes

Are there any helpers you need to implement?
These can be from other open source projects, as long as you credit them
There is a helper function 'getMax' which will be used within the countingSort method.

countingSort(int[] arr):
This is the main implementation of the Counting Sort algorithm. It doesn't require any additional helper classes or methods outside of the ones provided. It relies on the getMax function to determine the maximum value in the array.

getMax(int[] arr, int n):
This is a helper function for the countingSort method.
Role: It finds the maximum value in the array.
Why it's needed: Counting Sort requires knowledge of the maximum value in the array to initialize the counting array. By knowing the maximum value, you can set the size of the counting array, ensuring all possible numbers in the input array can be counted.

### Test Suites

Provide a section for each test suite that is planned and a paragraph describing what it will do.

The primary unit and efficiency  tests we included are:

1)TestEfficiency.java:

"testefficiency.java" evaluates the sorting algorithm's efficiency and performance. It measures execution time and resource usage across various input scenarios, confirming that the algorithm meets the paper's efficiency goals.

2)TestHybridsort.java:

"testhybridsort.java" verifies the correctness of the "hybridsort" component, ensuring that counting sort and quick sort combine correctly.

#### Functionality testing


## Status

Add section using the current date as the heading and describe the status in a few sentences or a few paragraphs.

09/28/2023: We have created java classes (CountingSort.java, HybridSort.java, QuickSort.java, Main.java,TestHybridSort.java)
10/12/2023: We have additionally added TestEfficiency.java and had started doing survey on the existing code.
10/15/2023: We have updated the sources.txt. 
11/05/2023: We have done some simple testing on counting sort .
11/19/2023: We have done some simple testing on hybrid sort .
12/17/23:We made changes in the code to  hybridize the sort and added Test cases.






