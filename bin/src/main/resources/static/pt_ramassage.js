var map, drawControls, kmllayer,points,icon;

icon = new OpenLayers.Icon('http://maps.google.com/mapfiles/ms/micons/red.png');
points =new OpenLayers.Layer.Vector('Points', {
    styleMap: new OpenLayers.StyleMap({
        pointRadius: "${type}", // based on feature.attributes.type
        label :"${name}",
        fontSize: "20px",
        labelAlign: "lb",
        fillColor: "#666666"
    })
});


var apiKey = "Au2r8DSGmoBKWxlwGjGhci4nUNGzfpuPJujkqsFwEw6D1zY3rLRhA4Y8JLWUCKVe";



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

               
                      
                
                
                map.addLayers([road, aerial, hybrid, pointLayer,points]);
                
               
                
                
                //map.addControl(new OpenLayers.Control.LayerSwitcher());
                map.addControl(new OpenLayers.Control.MousePosition());

                drawControls = new OpenLayers.Control.DrawFeature(pointLayer, OpenLayers.Handler.Point);


                 drawControls.events.register('featureadded', drawControls, function(evt) {
                 var geom = evt.feature.geometry;
                 console.log(evt.feature);
                        $('#geometry').val("POINT("+geom.x+" "+geom.y+")");
                        $('#exampleModalLong').modal();
                        
                });

                    map.addControl(drawControls);
                    var center = new OpenLayers.LonLat(0,0);
                   var center = new OpenLayers.LonLat(-7.60,33.58);
                    center.transform(new OpenLayers.Projection("EPSG:4326"), map.getProjectionObject());
                    map.setCenter(center,12);
                    $("#ajouter").click(function() {
                        drawControls.activate();
                       });
                     
            }
            
            function addpoints(pts) {
            	var features = new Array();
                for(m in pts){
                	pt=new OpenLayers.Feature.Vector(
                			new OpenLayers.Geometry.Point(pts[m][0],pts[m][1]) , { type: 5 , name: m}
                			);
                	features.push(pt);
                }
                points.addFeatures(features);
            }
            
            