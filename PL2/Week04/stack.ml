type 'a stack = 
  { mutable s: 'a list } 
;;

exception EmptyStack;;

let new_stack () = 
  let stk = {s = []} in stk
;; 

let pop stk = 
  match stk.s with
    hd::tl -> stk.s <- tl; hd
  | [] -> raise EmptyStack
;;

let push stk n = 
  stk.s <- [n] @ stk.s
;;

let stk= new_stack ();;
push stk "Bruh";;
push stk "--";;
push stk "Moment";;
pop stk;;
pop stk;;
pop stk;;
pop stk;;