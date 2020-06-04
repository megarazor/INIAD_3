let rec myjoin xs str =
  match xs with
    hd::tl -> hd ^ str ^ myjoin tl str
  | [] -> ""
;;

  myjoin ["aiueo"; "kakikukeko"; "sasisuseso"; "tatituteto"; "naninuneno"] "+";;