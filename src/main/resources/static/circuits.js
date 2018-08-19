var map, drawControls;

            function init(){
                map = new OpenLayers.Map('map');

                var wmsLayer = new OpenLayers.Layer.WMS( "OpenLayers WMS",
                    "http://vmap0.tiles.osgeo.org/wms/vmap0?", {layers: 'basic'});
                map.addLayers(wmsLayer);
                if(kml==""){
                var lineLayer = new OpenLayers.Layer.Vector("Line Layer");
                map.addLayers(lineLayer);
                map.addControl(new OpenLayers.Control.LayerSwitcher());
                map.addControl(new OpenLayers.Control.MousePosition());

                drawControls = new OpenLayers.Control.DrawFeature(lineLayer,
                        OpenLayers.Handler.Path)

                  var p="LINESTRING("
                 drawControls.events.register('featureadded', drawControls, function(evt) {
                 var geom = evt.feature.geometry;
                 for(var key in geom.components)
                     p=p+geom.components[key].x+" "+geom.components[key].y+",";
                 
                     var poly = p.substring(0, p.lastIndexOf(","));
                     poly=poly+")";
                     var km= geom.getLength();
                    $('#geometry').val(poly);
                	$('#km').val(km);
                        
                });

                    map.addControl(drawControls);
                    map.setCenter(new OpenLayers.LonLat(0, 0), 3);
                        drawControls.activate();
                       
                    
            }
                else{
                	kmllayer = new OpenLayers.Layer.Vector("KML", {
    				    strategies: [new OpenLayers.Strategy.Fixed()],
    				    protocol: new OpenLayers.Protocol.HTTP({
    				        url: kml,
    				        format: new OpenLayers.Format.KML({
    				            extractStyles: true, 
    				            extractAttributes: true,
    				            maxDepth: 2
    				        })
    				    })
    				})
                	 map.addLayers(kmllayer);
                	 map.setCenter(kmllayer.getDataExtent().getCenterLonLat(), 5);
                	 var geom = kmllayer.features[0].geometry;
                	 for(var key in geom.components)
                         p=p+geom.components[key].x+" "+geom.components[key].y+",";
                     
                         var poly = p.substring(0, p.lastIndexOf(","));
                         poly=poly+")";
                        $('#geometry').val(poly);
                    	$('#km').val(geom.getLength());
                }
            }
        
            
           