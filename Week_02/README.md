### HashMap总结
1. 没有hash碰撞情况下，put /get操作平均时间复杂度O(1)。
  - put操作会将计算出key 的hashcode, 然后key 、hashcode 、value一起创建成一个HashMap$Node对象，存入HashCode内部数组table中（其中HashMap$Node implements Map.Entry）。
  - get操作会计算出key的hashcode -> 根据hashcode计算出对应的value在table的下标 -> 根据下标获取value。
2. hash碰撞的情况下，put/get操作平均时间复杂度可能达到O(n)。
  - hash碰撞的原因：不同的key计算出相同的hashcode，导致不同的value要保存在table的同一个位置上。
  - hash碰撞的处理：HashMap$Node数组table中的元素生成链表或者红黑树。
