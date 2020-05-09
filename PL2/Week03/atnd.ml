let mymap f mylist =
  List.fold_left (fun result x->
    (f x) :: result
   ) []  (List.rev mylist);;


let mymap2 f myList =
  let rec iter func ls res = 
    match ls with
      hd::tl -> iter func tl (res @ [func hd])
    | [] -> res
  in iter f myList []
;;
