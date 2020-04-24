let rec even_vs_odd a b c d e =
  if (a mod 2) + (b mod 2) + (c mod 2) + (d mod 2) + (e mod 2) < 3 then true
  else false ;;

even_vs_odd 1 2 3 4 5;;
even_vs_odd 2 (-3) 4 5 (-6);;