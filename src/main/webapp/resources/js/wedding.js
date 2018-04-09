/*GET POSITION FROM DRAG*/
PrimeFaces.widget.Droppable.prototype.bindDropListener = function() {
   var _self = this;

   this.cfg.drop = function(event, ui) {
       if (_self.cfg.onDrop) {
           _self.cfg.onDrop.call(_self, event, ui);
       }
       if (_self.cfg.behaviors) {
           var dropBehavior = _self.cfg.behaviors['drop'];

           if (dropBehavior) {
               var ext = {
                    params: [
                       {name: _self.id + '_dragId', value: ui.draggable.attr('id')},
                       {name: _self.id + '_dropId', value: _self.cfg.target},
                       {name: ui.draggable.attr('id') + '_left', value: ui.position.left},
                       {name: ui.draggable.attr('id') + '_top', value: ui.position.top}
                    ]
                };

                dropBehavior.call(_self, ext);
           }
       }
    };
}