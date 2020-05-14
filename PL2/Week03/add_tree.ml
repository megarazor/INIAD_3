type 'a btree = 
  Node of 'a * 'a btree * 'a btree
| Leaf
;;

let rec append_bst value tree = 
  match tree with
    Node(v, t1, t2) when value < v -> Node(v, append_bst value t1, t2)
  | Node(v, t1, t2) when value > v -> Node(v, t1, append_bst value t2)
  | Node(_, _, _) -> tree
  | Leaf -> Node(value, Leaf, Leaf)
;;


append_bst 5 (Node(8, Node(3, Node(1, Leaf, Leaf), Leaf), Node(10, Leaf, Leaf)));;

append_bst 0 (Node(8, Node(3, Node(1, Leaf, Leaf), Leaf), Node(10, Leaf, Leaf)));;

(Node(8, Node(3, Node(1, Leaf, Leaf), Leaf), Node(10, Leaf, Leaf)));;

append_bst 1 (Node(8, Node(3, Node(1, Leaf, Leaf), Leaf), Node(10, Leaf, Leaf)));;