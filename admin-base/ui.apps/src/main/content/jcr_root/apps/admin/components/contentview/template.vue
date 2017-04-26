<template>
    <div class="fullheight">
        <div id="editviewoverlay" style="position: absolute;" v-on:click="click" v-on:dragover="dragOver" v-on:drop="drop">
            <div id="editable" style="position: absolute; border: solid 1px blue; width: 10px; height: 10px;"></div>
        </div>
        <iframe id="editview" v-bind:src="pagePath" width="100%" height="100%" frameborder="0" style="padding-top: 2px"></iframe>
    </div>
</template>

<script>
export default {
    props: ['model'],
    mounted: function() {
        this.resizeOverlay()
        window.addEventListener('resize', this.resizeOverlay)
    },
    beforeDestroy: function () {
      window.removeEventListener('resize', this.resizeOverlay)
    },
    computed: {
        pagePath: function() {
            return perAdminView.pageView.path + '.html'
        }
    },
    methods: {

        resizeOverlay: function(event) {
            var rect = this.$el.children['editview'].getBoundingClientRect()
            var overlay = this.$el.children['editviewoverlay']
            overlay.style.width = ''+(rect.width-20)+'px'
            overlay.style.height = ''+(rect.height-20)+'px'
        },
        getTargetEl: function(e) {
            var elRect = this.$el.getBoundingClientRect()

            var posX = e.clientX - elRect.left
            var posY = e.clientY - elRect.top

            var editview = this.$el.children['editview']
            var editable = this.$el.children['editviewoverlay'].children['editable']

            var targetEl = editview.contentWindow.document.elementFromPoint(posX, posY)
            if(!targetEl) return

            while(!targetEl.getAttribute('data-per-path')) {
                targetEl = targetEl.parent
                if(!targetEl) { break; }
            }
            return targetEl
        },
        click: function(e) {
            if(!e) return
            var targetEl = this.getTargetEl(e)
            if(targetEl) {
                perHelperAction(this, 'showComponentEdit', targetEl.getAttribute('data-per-path'))
            }
        },

        leftArea: function(e) {
//            var editable = this.$el.children['editviewoverlay'].children['editable']
//            editable.style.display = 'none'
        },

        dragOver: function(e) {
            e.preventDefault()

            var elRect = this.$el.getBoundingClientRect()

            var posX = e.clientX - elRect.left
            var posY = e.clientY - elRect.top


            var editview = this.$el.children['editview']
            var editable = this.$el.children['editviewoverlay'].children['editable']


           var targetEl = editview.contentWindow.document.elementFromPoint(posX, posY)

            while(!targetEl.getAttribute('data-per-path')) {
                targetEl = targetEl.parent
                if(!targetEl) { break; }
            }

            if(targetEl) {
                if(targetEl.getAttribute('data-per-path') !== this.currentPath) {
                    console.log(targetEl.getAttribute('data-per-path'))
                    var targetBox = targetEl.getBoundingClientRect()

                    editable.style.top = targetBox.top+'px'
                    editable.style.left = targetBox.left+'px'
                    editable.style.width = targetBox.width+'px'
                    editable.style.height = targetBox.height+'px'
                    editable.style.display = 'block'

                    this.currentPath = targetEl.getAttribute('data-per-path')
                }
            }

        },

        showComponentEdit: function(me, target) {
            perHelperModelAction('editComponent', target)
        },

        drop: function(e) {
            var editable = this.$el.children['editviewoverlay'].children['editable']
            editable.style.display = 'none'

            var targetEl = this.getTargetEl(e)

            var componentPath = e.dataTransfer.getData('component')

            perHelperModelAction('addComponentToPath', { pagePath : perAdminView.pageView.path, path: targetEl.getAttribute('data-per-path'), component: componentPath})
        }
    }
}
</script>