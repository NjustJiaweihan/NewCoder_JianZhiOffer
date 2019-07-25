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

解释一下

