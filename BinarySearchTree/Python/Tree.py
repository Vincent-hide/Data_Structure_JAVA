from Node import Node

class Tree:
  def __init__(self):
    self.root = None
    self.count = 0

  def insert(self, data):
    self.count += 1
    if(self.root == None):
      node = Node(data)
      self.root = node
      return

    current = self.root
    parent = self.root

    while(current is not None):
      parent = current
      if(current.data > data):
        current = current.left
      else:
        current = current.right

    if(parent.data > data):
      parent.left = Node(data)
    else:
      parent.right = Node(data)

  def count(self):
    return f'''
      tree has {self.count} nodes attached
    '''

  # In Order Traversal
  def inOrder(self):
    self.inOrderRec(self.root)

  def inOrderRec(self, node = None):
    if(node is not None):
      self.inOrderRec(node.left)
      print(node.data)
      self.inOrderRec(node.right)