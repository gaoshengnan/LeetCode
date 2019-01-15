#### 以下部分是[判断链表是否有环](https://github.com/gaoshengnan/LeetCode/blob/master/src/main/java/linkedlist/linkedListCycle/LinkedListCycle.java)的扩展

### 五、链表有环扩展LeetCode142

> - 英文版：[https://leetcode.com/problems/linked-list-cycle-ii/](https://leetcode.com/problems/linked-list-cycle-ii/)
> - 中文版：[https://leetcode-cn.com/problems/linked-list-cycle-ii/](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

#### 题意解析：如果链表有环，返回该环的入口结点，如下图所示：
<div align="center"><img src="/img/linkedListCycle/6.png" height="230" width="600" ></div>

上面图中fast指针的low指针同时从A结点出发，fast每次走两步，low每次走一步，在G结点相遇，发现链表有环，不难观察出fast和low的路线如下图：
<div align="center"><img src="/img/linkedListCycle/7.png" height="250" width="600" ></div>

然后假设起始结点A到环入口点C的距离是x，入口点C到相遇点的距离是y，相遇点到入口点的距离是z，所以得出以下结论：
<div align="center"><img src="/img/linkedListCycle/8.png" height="200" width="600" ></div>

所以解题思路是当发现快指针fast和慢指针low相遇之后，让fast指针从起始结点出发，再次相遇的点就是环的入口点。

