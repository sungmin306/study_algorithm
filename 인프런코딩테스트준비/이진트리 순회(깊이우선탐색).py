class Node(object):
    def __init__(self, item):
        self.item = item
        self.left = self.right = None


class BinaryTree(object):
    def __init__(self):
        self.root = None


def preorder(self):  # 전위순회
    def _preorder(node):
        print(node.item, end='')
        if node.left:
            _preorder(node.left)
        if node.right:
            _preorder(node.right)
    _preorder(self.root)
