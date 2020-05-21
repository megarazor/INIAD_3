exception EmptyStack;;

type 'a t = 
  { mutable s: 'a list } 
;;

let create () = 
  let stk = {s = []} in stk
;; 

let pop stk = 
  match stk.s with
    hd::tl -> stk.s <- tl; hd
  | [] -> raise EmptyStack
;;

let push n stk = 
  stk.s <- [n] @ stk.s
;;