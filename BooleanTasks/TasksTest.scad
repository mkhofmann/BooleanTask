union(){
union(){
import("LegoTest.stl",3);
translate([0.0,0.0,-3.0]) cube([40.0,40.0,3.0]);
};
rotate([180.0,0.0,0.0]) union(){
cylinder(r=5.0,h=10.0);
translate([0.0,0.0,-3.0]) cube([40.0,40.0,3.0]);
};
}
