module.exports = {
    convert: function($, f) {
    	f.wrap($, 'themeclean-components-block')
        f.bindAttribute($.parent(),'model','model')
        f.mapRichField( $.find('blockquote'), 'model.text')
        f.addIf($.find('.perIsEditAndEmpty').first(), 'isEditAndEmpty')
    }
}