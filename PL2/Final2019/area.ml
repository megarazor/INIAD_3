type figure =
  Circle of float                (* Circle(r) represents a circle whose radius is r *)
| Rectangle of float * float     (* Rectangle(w, h) represents a rectangle with width w and height h *)

let area f =
  match f with
    Circle(r) -> r *. r *. 3.14159
  | Rectangle(a, b) -> a *. b
;;

area (Circle(2.0));;
area (Rectangle(3.0, 4.0));;