##  K个一组翻转链表
> - 英文版：[https://leetcode.com/problems/reverse-nodes-in-k-group/](https://leetcode.com/problems/reverse-nodes-in-k-group/)
> - 中文版：[https://leetcode-cn.com/problems/reverse-nodes-in-k-group/](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

### 题意：

首先，我们以7个结点的链表为例，假设K等于3，那么反转前后链表如下图所示：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/1.png" height="150" width="700" ></div>

> 注：以下所有思路，请参考上面ReverseNodesInkGroup.java里给出的推荐答案进行阅读。
> 还有推荐答案里的head = pre == null ? cur : head，为了不扰乱整理逻辑，这句话暂时先不管，是用来标识时刻变化的链表的第一个结点，以便最后返回。

### 第一轮K个结点反转

首先看到推荐答案中代码有点多，没关系，可以先什么都不管，第一轮K个结点反转只要从cur=head入手，然后进入while循环，然后看下图观察cur随count的变化：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/2.png" height="180" width="700" ></div>

可以看出count从1到3，cur从结点1走到结点3，然后进入if条件语句。开始给start赋值，首先pre是null，所以start表示从head开始，随后给left，start，end，right赋值，赋值之后如下图所示：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/3.png" height="180" width="700" ></div>

进入resign方法，分别用p，c，n指针来反转K个结点，此处和[反转单链表](https://github.com/gaoshengnan/LeetCode/tree/master/src/main/java/linkedlist/reverseList)思路类似，K个结点反转过程如下图：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/4.png" height="250" width="700" ></div>

由图可以看出当n等于right的时候停止反转，并将结点1（反转后的尾结点）和结点4（下一组K个结点的首结点）连上。随后将pre指向第一个K组结点反转后的尾结点（也就是下一组K结点的前一个结点），并将cur指向下一组K结点的首结点，以上一轮大的while循环结束。如下图可见指针情况：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/5.png" height="200" width="700" ></div>

### 第二轮K个结点反转
进入第二轮K个结点反转，cur随着count++从结点4移动到结点6，如下图所示：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/6.png" height="170" width="700" ></div>

然后继续调用resign方法，给left，start，end，right赋值，如下图所示：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/7.png" height="170" width="700" ></div>

进入resign方法，开始反转第二组K个结点，需要注意的是，此时left不为null，要将上一组K个结点和这一组K个结点连上，如下图：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/8.png" height="250" width="700" ></div>

最后调整指针如下图：
<div align="center"><img src="../../../resources/img/reverseNodeInKGroup/9.png" height="130" width="700" ></div>

然后当count=2时，不满足条件，退出循环，返回head。
