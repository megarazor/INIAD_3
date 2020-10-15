type 'a btree = 
  Node of 'a * 'a btree * 'a btree
| Leaf

let rec contains t e =
  match t with
    Node(v, _, _) when v = e -> true
  | Node(v, left, right) -> (contains left e) || (contains right e)
  | Leaf -> false
;;

let tree = Node(1, Node(3, Leaf, Node(6, Leaf, Leaf)), Node(4, Leaf, Node(2, Leaf, Leaf)));;

contains tree 5;;
contains tree 6;;
contains tree 2;;
contains tree (-2);;