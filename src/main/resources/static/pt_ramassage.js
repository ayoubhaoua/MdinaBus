var map, drawControls;

            function init(){
                map = new OpenLayers.Map('map');

                var wmsLayer = new OpenLayers.Layer.WMS( "OpenLayers WMS",
                    "http://vmap0.tiles.osgeo.org/wms/vmap0?", {layers: 'basic'});
                

                var pointLayer = new OpenLayers.Layer.Vector("Point Layer");

                map.addLayers([wmsLayer, pointLayer]);
                map.addControl(new OpenLayers.Control.LayerSwitcher());
                map.addControl(new OpenLayers.Control.MousePosition());

                drawControls = new OpenLayers.Control.DrawFeature(pointLayer, OpenLayers.Handler.Point);


                 drawControls.events.register('featureadded', drawControls, function(evt) {
                 var geom = evt.feature.geometry;
                        $('#geometry').val("POINT("+geom.x+" "+geom.y+")");
                        $('#exampleModalLong').modal();
                        
                });

                    map.addControl(drawControls);
                    map.setCenter(new OpenLayers.LonLat(0, 0), 3);
                    
                    
                    $("#ajouter").click(function() {
                        drawControls.activate();
                       });
                    
            }
        
            
            