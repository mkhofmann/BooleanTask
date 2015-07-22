difference()  {
difference()  {
translate([-29.0,-29.0,0.0])  cube([58.0,58.0,100.0]);
union()  {
translate([-11.0,-11.0,0.0])  cube([22.0,22.0,60.0]);
translate([0.0,0.0,60.0])  translate([-26.0,-26.0,0.0])  cube([52.0,52.0,28.0]);
translate([-11.0,0.0,0.0])  cube([22.0,29.0,74.0]);
translate([-26.0,0.0,74.0])  cube([52.0,29.0,14.0]);
}
}
translate([0.0,0.0,50.0])  {
translate([-17.5,-17.5,0.0])  cylinder(r=4.5,h=10.0);
translate([17.5,-17.5,0.0])  cylinder(r=4.5,h=10.0);
translate([-17.5,17.5,0.0])  cylinder(r=4.5,h=10.0);
translate([17.5,17.5,0.0])  cylinder(r=4.5,h=10.0);
}
}
difference()  {
union()  {
translate([0.0,0.0,60.0])  translate([-25.0,-25.0,0.0])  cube([50.0,50.0,13.0]);
translate([0.0,0.0,-26.0])  translate([-10.0,-10.0,0.0])  cube([20.0,20.0,86.0]);
}
translate([0.0,0.0,60.0])  {
translate([-17.5,-17.5,0.0])  cylinder(r=4.5,h=10.0);
translate([17.5,-17.5,0.0])  cylinder(r=4.5,h=10.0);
translate([-17.5,17.5,0.0])  cylinder(r=4.5,h=10.0);
translate([17.5,17.5,0.0])  cylinder(r=4.5,h=10.0);
}
}
