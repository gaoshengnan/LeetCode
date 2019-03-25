# LeetCode


### 一、数据结构和算法
掌握数据结构和算法直接的好处就是能写出性能更优的代码。算法是一种解决问题的思路和方法，从长期来看，大脑思考能力是个人最重要的核心竞争力，而算法是为数不多的能够训练大脑思考能力的途径之一。

关于要不要学数据结构和算法以及算法有没有用这种问题不想再多做解释，只能说志同道合者共行，如果你也感兴趣，可以和我一起学习数据结构和算法题。

> 学习路线看书学习数据结构基础知识，通过LeetCode算法题加深对数据结构的理解。

### 二、练习题目
该项目LeetCode主要包括：LeetCode推荐答案+详细备注+算法题思路说明文档。相关题目及答案如下链接：
#### 链表
[206-reverse-linked-list-反转链表](https://github.com/gaoshengnan/LeetCode/tree/master/src/main/java/linkedlist/reverseList)  
[141-linked-list-cycle-环形链表（判断是否有环）](https://github.com/gaoshengnan/LeetCode/tree/master/src/main/java/linkedlist/linkedListCycle)  
[142-linked-list-cycle-ii-环形链表II（如果有环，返回入环结点）](https://github.com/gaoshengnan/LeetCode/tree/master/src/main/java/linkedlist/linkedListCycleII)  
[24-swap-nodes-in-pairs-两两交换链表中的结点](https://github.com/gaoshengnan/LeetCode/tree/master/src/main/java/linkedlist/swapNodesInPairs)  
[25-reverse-nodes-in-k-group-K个一组反转链表](https://github.com/gaoshengnan/LeetCode/tree/master/src/main/java/linkedlist/reverseNodesInkGroup)  
[使用栈实现一个队列](https://github.com/gaoshengnan/LeetCode/tree/master/src/main/java/stack/ImplementQueueUsingStacks)
[20-valid-parentheses-有效括号](https://github.com/gaoshengnan/LeetCode/tree/master/src/main/java/stack/validParentheses)

> 持续更新中。。。

### 三、常见数据结构

#### 1、数组
数组是一种线性表数据结构，它用一组连续的内存空间，来存储一组具有相同类型的数据。

#### 1.1 访问
数组适合查找操作，排好序的数组，用二分法查找，时间复杂度是O(logn)。数组支持随机访问，根据下标随机访问的时间复杂度是O(1)。

#### 1.2 插入
如果在数组末尾插入，不需要移动数据，时间复杂度是O(1)，如果在数组的开头插入元素，那么所有的数据都要一次往后移动一位，最坏时间复杂度是O(n)。

如果数组中的数据是有序的，那就必须移动其他数据来完成插入操作；但是如果是无序的，当将某个数据插入到数组第k个位置时，可以直接将第k位的数据直接放入到数组最后，把新的元素放在第k个位置。

#### 1.3 删除
和插入类似，删除末尾数据，最好时间复杂度是O(1)，删除开头数据，最坏时间复杂度是O(n)。

在一些特殊场景中，我们不追求数据的连续性，可以将已删除的数据标记下来，这样每次的删除操作不是真正的进行搬移数据，而只是记录数据已经被删除，当数组没有更多空间存储数据时，再触发一次真正的删除操作，这样大大减少了删除导致的数据搬移。类似JVM的标记清楚算法。

#### 1.4 ArrayList和原声的数组比较
1、ArrayList最大的优势是可以将很多数组操作的细节封装起来，比如数组插入或者删除时需要搬移数据的操作，另外还有一个优势就是支持动态扩容。

动态扩容是指数组本身在定义的时候需要预先指定大小，因为需要分配连续的内存空间，如果我们申请了大小为10的数组，当11个数据需要存储到数组中时，我们就需要重新分配一块更大的空间，将原来的数据复制过去，然后再将新的数据插入。

2、ArrayList无法存储基本类型，比如int，long，需要封装成Integer、Long类，而Autoboxing、Unboxing则有一定的性能消耗，所以如果特别关注性能的话，或者希望使用基本类型的时候就可以选择数组。

3、总的来说，业务开发，直接使用容器就可以了，省时省力，毕竟损耗一丢丢性能，完全不会影响到系统整体的性能，但是如果你是做一些非常底层的开发，比如开发网络框架，性能的优化需要做到极致，这个时候数组就会优于容器。

#### 1.5 为什么编程中数组从0开始编号 ？
k：索引下标
a[k]_address：第k个数据的内存地址
base_address：数组内存的首地址
type_size：存储的数据大小（比如int占4个字节）

计算数组内存地址的位置公式是a[k]_address = base_address + k * type_size，如果从1开始编号的话，公式就变成a[k]_address=base_address + (k-1) * type_size，对于CPU来说，每次随机访问数组都多了一次减法指令，为了减少一次减法操作，所以数组就选择了从0开始编号索引下标。


