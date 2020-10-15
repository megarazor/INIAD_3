let rec isprime_helper n i =
  if (i <= 1) then true
  else if (n mod i = 0) then false
  else isprime_helper n (i - 1) ;;

let isprime n =
  isprime_helper n (n - 1) ;;
2;;
isprime 2 ;;
3;;
isprime 3 ;;
4;;
isprime 4 ;;
5;;
isprime 5 ;;
6;;
isprime 6 ;;
7;;
isprime 7 ;;
8;;
isprime 8 ;;
9;;
isprime 9 ;;
10;;
isprime 10 ;;