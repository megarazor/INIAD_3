type 'a btree = 
  Node of 'a * 'a btree * 'a btree
| Leaf
;;

type 'a option = 
  Some of 'a
| None
;;

let rec find_max tree = 
  match tree with 
    Node(v, t1, t2) when t2 = Leaf -> Some(v)
  | Node(v, t1, t2) -> find_max t2
  | Leaf -> None
;;

let rec remove_bst value tree =
  match tree with
    Node(v, t1, t2) when value < v -> Node(v, remove_bst value t1, t2)
  | Node(v, t1, t2) when value > v -> Node(v, t1, remove_bst value t2)
  | Node(v, t1, t2) -> 
      let max_left = find_max t1 in
      begin
        match max_left with
          Some(m) -> Node(m, remove_bst m t1, t2)
        | None -> Leaf
      end
  | Leaf -> tree
;;

(Node(8, Node(3, Node(1, Leaf, Leaf), Leaf), Node(10, Leaf, Leaf)));;
remove_bst 8 (Node(8, Node(3, Node(1, Leaf, Leaf), Leaf), Node(10, Leaf, Leaf)));;

(Node(10, Node(5, Node(1, Node(0, Leaf, Leaf), Node(4, Node(3, Leaf, Leaf), Leaf)), Leaf), Leaf));;
remove_bst 5 (Node(10, Node(5, Node(1, Node(0, Leaf, Leaf), Node(4, Node(3, Leaf, Leaf), Leaf)), Leaf), Leaf));;
