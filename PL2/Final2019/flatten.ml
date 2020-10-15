type 'a btree = 
  Node of 'a * 'a btree * 'a btree
| Leaf
;;

let rec flatten tree =
  match tree with
    Node(this, left, right) -> (flatten left) @ [this] @ (flatten right)
  | Leaf -> []

;;

flatten (Node(1, Node(2, Leaf, Node(3, Leaf, Leaf)), Node(4, Leaf, Leaf)));;