type memo = 
  { mutable content: string } 
;;

let s= {content = ""};;
s.content <- read_line ();;
print_string (s.content ^ "\n");;