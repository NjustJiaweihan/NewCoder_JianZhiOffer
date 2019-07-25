## 链表中环的入口结点

### 判断是否有环 --> 快慢指针

```java
ListNode slow = pHead;
ListNode fast = pHead;

while (fast != null){

    slow = slow.next;
    fast = fast.next.next;
    
    if(slow == fast){
        //此时是相遇点 不是环入口
        return slow;
    }
}
return null;
```
### 寻找环入口点

在fast与slow相遇之后

```java
fast = pHead;
while (fast != slow){

    fast = fast.next;
    slow = slow.next;
}
//此时是环入口
return slow;
```

解释一下为什么这样就可以找到环入口：

- 设环长n 链表总长l
- fast与slow相遇时 设slow走了x个结点 fast是两倍速则为2x
- fast第一次与slow相遇一定是fast超了slow一圈(环长) 则2x = x + n --> x = n
- 相遇时 slow走了n 链表全长l 所以相遇点距离环入口为l-n
- 环长n 链表长l 所以pHead距离环入口为l-n
- 所以两个指针 一个从pHead出发 一个从相遇点出发 再次相遇时就是环入口

