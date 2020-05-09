type 'a btree = 
  Node of 'a * 'a btree * 'a btree
| Leaf
;;

type 'a option = 
  Some of 'a
| None
;;

(* let count_bst tree =
  let rec iter count nodes = 
    if nodes = [] then count
    else
      let (count', nodes') = 
        List.fold_left (fun (ct, ns) n ->
          match n with
            Node(v, t1, t2) -> (ct + 1, t1::t2::ns)
          | Leaf -> (ct, ns)) (0, []) nodes        
      in iter (count + count') nodes'
  in iter 0 [tree]
;;

count_bst (Node(8, Node(3, Node(1, Leaf, Leaf), Leaf), Node(10, Leaf, Leaf)));;

count_bst Leaf;; *)

let rec min_bst tree = 
  match tree with
    Node(v, Leaf, t2) -> Some(v)
  | Node(v, t1, t2) -> min_bst t1
  | Leaf -> None
;;

min_bst (Node(8, Node(3, Node(1, Leaf, Leaf), Leaf), Node(10, Leaf, Leaf)));;

min_bst Leaf;;