class PriorityQueue:
  def __init__(self, max):
    self.max = max
    self.num = 0
    self.arr = []

  def isEmpty(self):
    return self.num == 0

  def isFull(self):
    return self.max == self.num

  def print(self):
    for i in range(self.num):
      print(self.arr[i])

  def getParentIndex(self, index):
    return (index - 1) // 2;

  def getLeftIndex(self, index):
    return (index * 2) + 1
  
  def getRightIndex(self, index):
    return (index * 2) + 2

  def swap(self, index1, index2):
    temp = self.arr[index1]
    self.arr[index1] = self.arr[index2]
    self.arr[index2] = temp

  def heapify(self, index):
    parentIndex = self.getParentIndex(index)

    while(parentIndex >= 0 and self.arr[index] > self.arr[parentIndex]):
      self.swap(parentIndex, index)

      index = parentIndex
      parentIndex = self.getParentIndex(index)

  def enqueue(self, data):
    if(self.isFull()):
      return False
    
    self.arr.append(data)
    self.heapify(self.num)
    self.num += 1
    return True

  def heapify_down(self, index):
    leftIndex = self.getLeftIndex(index)
    rightIndex = self.getRightIndex(index)

    current = self.arr[index]
    left = self.arr[leftIndex]
    right = self.arr[rightIndex]

    if current > left and current > right:
      return 

    while current < left or current < right:
      if current < left:
        self.swap(index, leftIndex)
        index = leftIndex
      else:
        self.swap(index, rightIndex)
        index = rightIndex
      
      leftIndex = self.getLeftIndex(index)
      rightIndex = self.getRightIndex(index)

      if right > self.num: break

      current = self.arr[index]
      left = self.arr[leftIndex]
      right = self.arr[rightIndex]


  def dequeue(self):
    if self.num == 0:
      return -1

    dequeued = self.arr[0]
    self.arr[0] = self.arr[self.num - 1]
    self.num -= 1
    self.heapify_down(0)
    return dequeued