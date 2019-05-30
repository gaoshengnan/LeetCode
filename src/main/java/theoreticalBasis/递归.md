#### 一、递归对于我个人而言
有人说，递归是一种优雅的问题解决办法，有人说，递归是一种算法或者一种编程技巧，其实无论别人怎么说，我相信大多数人初学 “递” “归” 的时候纠结去的过程叫“递”，回来的过程叫“归”，那么问题来了，去的时候做了什么，什么时候回来，回来的时候又做了什么？那我们带着问题继续阅读吧！

#### 二、正确姿势理解递归
每个递归函数都有基线条件和递归条件两个部分：基线条件又可以理解成是终止条件，表示停止调用自己，避免无限循环；递归条件是指继续调自己。

**函数调用栈**
在这之前你要知道，每次调用函数，计算机都会像栈中压入一个栈帧，直到这个函数调用结束之后，会让栈帧出栈。请看以下代码：
```java
public static void test() { 
    System.out.println("seina");
}

public static void main(String[] args) {
    test(); // 调用test函数
}
```
以上 main 函数中调用了 test 函数，对于计算机来说，当程序调用 main 时，会**将 main 函数压入栈帧**，然后进入 test 函数，**将 test 函数压入栈帧**，test 函数中输出 “seina”，test 函数结束，函数调用栈将 **test 函数的栈帧出栈**，随后 main 函数结束，将 **main 函数的栈帧也出栈**。

**通过阶乘观察递归过程**
接下来结合调用栈来理解，先看下面一段代码，表示计算阶乘的递归函数：
```python
def fact(x):
	if x == 1: //如果 x 等于 1，直接返回 1 的阶乘，就是 1 
		return 1
	else: // 如果 x 不等于 1，开始递归求解
		return x * fac(x-1)
```
理解了代码之后，我们假如求 fact (3)，看看计算机到底是怎么执行上面一段函数的。
当我们第一次调用fact函数时，传入 x = 3 ：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190417234406895.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zODExODAxNg==,size_16,color_FFFFFF,t_70)
当程序不满足 if 条件是，进入else，开始递归，第二次调用fact，传入 x = 2 ：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190417235046497.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zODExODAxNg==,size_16,color_FFFFFF,t_70)
第二次调用结束之后，开始第三次调用，传入 x = 1，满足 if x == 1 的条件，继续执行 return 1，这时我们可以知道 fact（1）这个函数的返回值是 1 ，即fact（1）= 1。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190417235717658.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zODExODAxNg==,size_16,color_FFFFFF,t_70)
以上的x == 1就是递归的基准条件，else 之后就是递归条件。当满足基准条件之后，笑脸之后表示开始所谓的“归”的过程。
从上图可以看出，fact（1）= 1，fact（2）= 2，fact（3）= 6，这样就实现了 3！= 3 * 2 * 1。

好了，到此位置，我们的第一个简单的递归例子就详细描述完了，如果你还是不理解，也真的没有关系，有些事情真的没有必要一直去死磕，后面我们会在继续举几个递归的例子，加深对递归的理解，毕竟有些事情就是要靠刻意的多练习才能掌握的！

#### 三、什么情况下使用递归？
递归需要满足的三个条件：
 1. 一个规模大问题的解可以分解成几个规模较小问题的解
 2. 规模大问题和规模小问题的求解思路完全一样
 3. 存在递归终止条件
 
以上三个条件既涉及到分而治之的思想，又涉及到递归。我们再通过一个例子来加深对三个条件的理解。

假如我有一块640 * 400 的一块地，要将这块地均匀的分成正方块，且分出的方块要尽可能大，你也可以在纸上画出其他的，来跟我的进行比较，如下图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418211931718.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zODExODAxNg==,size_11,color_FFFFFF,t_70)
先简单说下求解思路，先拿出一块400 * 400 的地，剩下240 *  400，再拿出 240 * 240，剩下160 * 240，再拿出160 * 160，身下160 * 80，分开成两份80 * 80 就ok了。

第一、终止条件是当空间的一条边是另一条边的整数倍，这样就可以均匀分成几个正方块，没有剩余。
第二、递归时，每次都以最短的一边为正方形的值，取出正方形。并将剩下的部分使用相同的算法，从第一次 640 * 400 -- > 400 * 240  -- > 240 * 160  -- > 160 * 80 ，不断地将问题分解，缩小问题规模，并对分解的部分执行相同的算法。

