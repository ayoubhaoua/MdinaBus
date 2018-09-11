var map, drawControls, kmllayer,markers,icon;

var apiKey = "Au2r8DSGmoBKWxlwGjGhci4nUNGzfpuPJujkqsFwEw6D1zY3rLRhA4Y8JLWUCKVe";

console.log(m);


            function init(){
            	
                map = new OpenLayers.Map('map');

                var wmsLayer = new OpenLayers.Layer.WMS( "OpenLayers WMS",
                    "http://vmap0.tiles.osgeo.org/wms/vmap0?", {layers: 'basic'});
                var road = new OpenLayers.Layer.Bing({
                    key: apiKey,
                    type: "Road",
                    metadataParams: {mapVersion: "v1"}
                });
                var aerial = new OpenLayers.Layer.Bing({
                    key: apiKey,
                    type: "Aerial"
                });
                var hybrid = new OpenLayers.Layer.Bing({
                    key: apiKey,
                    type: "AerialWithLabels",
                    name: "Bing Aerial With Labels"
                });
               

                var pointLayer = new OpenLayers.Layer.Vector("Point Layer");
                

               
                      
                
               
                var markers = new OpenLayers.Layer.Markers( "Markers" );
                map.addLayers([road, aerial, hybrid, pointLayer,markers]);
                var icon = new OpenLayers.Icon('http://maps.google.com/mapfiles/ms/micons/red.png');
               /* var m=new OpenLayers.Marker(new OpenLayers.LonLat(0,0),icon);
                
                markers.addMarker(m);*/
                
                function add_marker(latitude, longitude) {
                    var lonLat = new OpenLayers.LonLat(longitude, latitude)
                        .transform(
                            new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
                            map.getProjectionObject() // to Spherical Mercator Projection
                    );
                    var point = new OpenLayers.Marker(lonLat,icon);
                    markers.addMarker(point);
                    map.setCenter(lonLat, 8);
                    console.log(latitude + ", " + longitude);
                }
                
                
                //map.addControl(new OpenLayers.Control.LayerSwitcher());
                map.addControl(new OpenLayers.Control.MousePosition());

                drawControls = new OpenLayers.Control.DrawFeature(pointLayer, OpenLayers.Handler.Point);


                 drawControls.events.register('featureadded', drawControls, function(evt) {
                 var geom = evt.feature.geometry;
                        $('#geometry').val("POINT("+geom.x+" "+geom.y+")");
                        $('#exampleModalLong').modal();
                        
                });

                    map.addControl(drawControls);
                    var center = new OpenLayers.LonLat(0,0);
                   // var center = new OpenLayers.LonLat(-7.60,33.58);
                    center.transform(new OpenLayers.Projection("EPSG:4326"), map.getProjectionObject());
                    map.setCenter(center,12);
                    
                    
                    $("#ajouter").click(function() {
                        drawControls.activate();
                       });
                   
                   add_marker(0,0); 
            }
            
            
            