let rec even_vs_odd a b c d e =
  if (abs(a) mod 2) + (abs(b) mod 2) + (abs(c) mod 2) + (abs(d) mod 2) + (abs(e) mod 2) < 3 then true
  else false ;;

even_vs_odd 1 2 3 4 5;;
even_vs_odd 2 (-3) 4 5 (-6);;