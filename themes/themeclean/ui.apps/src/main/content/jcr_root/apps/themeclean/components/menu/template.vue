<template>
  <themeclean-components-block v-bind:model="model">
    <nav class="navbar align-items-center navbar-light w-100" v-bind:class="{'navbar-expand-lg':model.collapsed === 'false'}">
      <h1 v-if="editAndEmpty">Configure Menu</h1>
      <!-- Logo -->
      <span class="navbar-logo">
        <a v-bind:href="$helper.pathToUrl(model.logourl)">
          <img class="menu-logo" alt="logo" v-bind:src="$helper.pathToUrl(model.logo)"
          v-bind:style="`height:${parseInt(model.logosize)}rem;`">
        </a>
      </span>
      <!-- Hamburger toggle button -->
      <button class="navbar-toggler navbar-toggler-right" data-toggle="collapse"
      data-target="#navbarSupportedContent" aria-expanded="false" aria-controls="collapseExample">
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- Collapsible Menu -->
      <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <themeclean-components-textlinks v-bind:model="model"></themeclean-components-textlinks>
        <themeclean-components-menubuttons v-bind:model="model"></themeclean-components-menubuttons>
      </div>
    </nav>
  </themeclean-components-block>
</template>

<script>
    export default {
        props: ['model']
    }
</script>