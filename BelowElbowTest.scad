intersection()  {
translate([-20.0,-20.0,-20.0])  cube([40.0,40.0,90.0]);
union()  {
translate([0.0,0.0,60.0])  translate([-20.0,-20.0,0.0])  cube([40.0,40.0,10.0]);
translate([0.0,0.0,-20.0])  translate([-10.0,-10.0,0.0])  cube([20.0,20.0,80.0]);
}
}
