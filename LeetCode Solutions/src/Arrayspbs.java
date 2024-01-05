import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Arrayspbs {

public static void main(String[] args) {
// int a[] = {1,2,3,0,0,0};
// int b[] = {2,5,6};
// mergeGoodApproach(a,6,b, 3);

// int a[] = {1};
// int k= 0;
// ro(a,k);

// rotateArrayRight();

int a[] = {3,2,2,3};
System.out.println(removeElementforLeetcode(a,3));
}

//Basics funny examples from Java - 21/12/2023

int print2largest(int arr[], int n) {

//removing duplicates if it has any
int[] a = new int[n];
int j = 0;
Arrays.sort(arr);
for (int i = 0; i < n - 1; i++) {
if (arr[i] != arr[i + 1]) {
a[j++] = arr[i];
}
}
a[j++] = arr[n - 1];

//logic for finding 2nd largest
int fl, sl, temp;
fl = a[0];
sl = a[1];
if (sl > fl) {
temp = fl;
fl = sl;
sl = temp;
}

for (int i = 2; i < n; i++) {
if (a[i] > fl) {
sl = fl;
fl = a[i];
} else if (a[i] > sl) {
sl = a[i];
}
}
//if same numbers are given o/p will be 0 make it -1
if (sl == 0) {
return -1;
}
return sl;
}

static void removeDuplicates() {
int a[] = new int[10];
a[0] = 1;
a[1] = 2;
a[2] = 2;
a[3] = 3;
int result[] = new int[a.length];

int j = 0;
for (int i = 0; i < a.length - 1; i++) {
if (a[i] != a[i + 1]) {
result[j] = a[i];
j++;
}
}

result[j] = a[a.length - 1];

for (int i = 0; i < result.length; i++) {
System.out.println(result[i]);
}
}

public static void removeDuplicatesWithoutSorted() {
int n = 4;
Integer a[] = new Integer[n];
a[0] = 5;
a[1] = 2;
a[2] = 2;
a[3] = 3;
HashSet<Integer> set = new HashSet<>();
for (int i = 0; i < a.length; i++) {
set.add(a[i]);
}
a = set.toArray(new Integer[set.size()]);

for (int i = 0; i < a.length; i++) {
System.out.println(a[i]);
}
}

public static void arrayInsertion() {
int n = 4;
Integer a[] = new Integer[n];
a[0] = 5;
a[1] = 2;
a[2] = 3;
a[3] = 4;

int index_pos = 2, ele = 100; //position which it has to insert and what element

for (int i = a.length - 1; i > index_pos; i--) {
a[i] = a[i - 1];
}
a[index_pos] = ele;

for (int i = 0; i < a.length; i++) {
System.out.println(a[i]);
}
}

public static void arrayDeletion() {
int n = 4;
Integer a[] = new Integer[n];
a[0] = 5;
a[1] = 2;
a[2] = 3;
a[3] = 4;

Integer b[] = new Integer[n - 1];

int del = 2;
int j = 0;
for (int i = 0; i < a.length; i++) {
if (del != a[i]) {
b[j] = a[i];
j++;
}
}

for (int i = 0; i < b.length; i++) {
System.out.println(b[i]);
}
}


public static void arrayRotationNaiveApproach() {
int n = 7;
Integer a[] = new Integer[n];
a[0] = 1;
a[1] = 2;
a[2] = 3;
a[3] = 4;
a[4] = 5;
a[5] = 6;
a[6] = 7;

Integer b[] = new Integer[a.length];

Integer temp[] = new Integer[a.length];
int pos = 1;
int j = 0;
if(pos != a.length) {
for (int i = 0; i < pos; i++) {
temp[j] = a[i];
j++;
}

int k = 0;
for (int i = pos - 1; i < a.length - 1; i++) {
b[k] = a[i + 1];
k++;
}
int t = 0;
for (int i = 0; i < a.length; i++) {
a[t] = b[i];
t++;
}

for (int i = 0; i < temp.length; i++) {
a[k] = temp[i];
k++;
if (k == a.length) {
break;
}
}

}
for (int i = 0; i < a.length; i++) {
System.out.println(a[i]);
}

}

public static void rotateArrayGoodApproach()
{
Integer a[] = {1,2,3,4,5};

int pos = -1;
pos = pos % a.length;

if(pos<0)
{
pos = pos + a.length;
}
for(int i = 0; i < pos; i++)
{
rotateOneElementInArray(a);
}

for(int i = 0; i < a.length; i++)
{
System.out.println(a[i]);
}
}

public static void rotateArrayOptimalApproach()
{
Integer a[] = {1,2,3,4,5,6,7,8,9};
int pos = 4;
pos = pos % a.length;

if(pos<0)
{
pos = pos + a.length;
}

reverseArray(a, 0, pos-1);
reverseArray(a, pos, a.length-1);
reverseArray(a, 0, a.length-1);

for(int i = 0; i < a.length; i++)
{
System.out.println(a[i]);
}
}

public static void rotateOneElementInArray(Integer a[])
{
int temp = a[0];
for(int i = 0; i < a.length-1;i++)
{
a[i] = a[i+1];
}
a[a.length-1] = temp; //last position we should insert temp [2,3,4,5,1]
}

public static void reverseArray(Integer a[], int i, int j)
{
int temp;
while(i<j)
{
temp = a[i];
a[i] = a[j];
a[j] = temp;
i++;
j--;
}

}

public static void merge(int[] num1, int m, int[] num2, int n) {
int temp[] = new int[m+n];
int j=0;
for(int i=0; i<m; i++)
{
if(num1[i] != 0)
{
temp[j] = num1[i];
j++;
}
}

int k=0;
for(int i = j; i< temp.length; i++)
{
if(num2[k] != 0) {
temp[j] = num2[k];
k++;
j++;
}
if(k == num2.length)
{
break;
}

}
Arrays.sort(temp);
for(int i=0; i<temp.length;i++)
{
if(temp[i]!=0)
System.out.print(temp[i]);
}
}

public static void mergeGoodApproach(int[] num1, int m, int[] num2, int n) {
// int temp[] = new int[m+n];
//// int j=1;
// int k=0;
// for(int i=0,j=1; i< temp.length; i++,j++)
// {
// if(num1[i]!=0 && num2[j]!=0)
// {
// temp[k] = num1[i];
// k++;
// temp[k] = num2[j];
// k++;
// }
// }
// Arrays.sort(temp);
// for(int i=0; i<temp.length;i++)
// {
// if(temp[i]!=0)
// System.out.print(temp[i]);
// }
}


public static void reverseArrayRig(int a[], int i, int j)
{
int temp;
while(i<j)
{
temp = a[i];
a[i] = a[j];
a[j] = temp;
i++;
j--;
}
}

public static void ro(int[] nums, int k) {


k = k % nums.length;
if (k < 0) {
k = k + nums.length;
}

if(k >=1) {


reverseArrayRig(nums, nums.length, k);
reverseArrayRig(nums, k - 1, 0);
reverseArrayRig(nums, 0, nums.length - 1);

reverseArrayRig(nums, 0, k - 1);
reverseArrayRig(nums, k, nums.length - 1);

}
for (int i = 0; i < nums.length; i++) {
System.out.println(nums[i]);
}
}

public static void rotateOneRight(Integer a[])
{
int temp = a[a.length-1];
int i;
for(i = a.length-1; i>0; i--)
{
a[i] = a[i-1];
}
a[0] = temp;
}

public static void rotateArrayRight()
{
Integer a[] = {1,2,3,4,5};

int pos = 2;
pos = pos % a.length;

if(pos<0)
{
pos = pos + a.length;
}
for(int i = 0; i < pos; i++)
{
rotateOneRight(a);
}

for(int i = 0; i < a.length; i++)
{
System.out.println(a[i]);
}
}

public static int removeElementforLeetcode(int[] nums, int val) {

int res[] = new int[nums.length];
int j=0;
for(int i=0; i<nums.length; i++)
{
if(nums[i] != val)
{
res[j] = nums[i];
j++;
}
}

for(int i=0;i<res.length;i++)
{
System.out.println(res[i]);
}
return j;
}

}