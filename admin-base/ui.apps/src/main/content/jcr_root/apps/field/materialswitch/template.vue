<template>
  <!-- Switch -->
  <div class="wrap">
	  <div v-if="!schema.preview" class="switch">
	    <label :for="getFieldID(schema)">
	      <input 
		      type="checkbox" 
					v-model="value" 
					:autocomplete="schema.autocomplete" 
					:disabled="disabled" 
					:name="schema.inputName" 
					:id="getFieldID(schema)">
	      <span class="lever"></span>
	      {{ value ? schema.textOn : schema.textOff}}
	    </label>
	  </div>
  	<p v-else>{{value}}</p>
	</div>
</template>

<script>	
	export default {
		mixins: [ VueFormGenerator.abstractField ],
		methods: {
			formatValueToField(value) {
				if (value != null && this.schema.valueOn)
					return value == this.schema.valueOn;
				return value;
			},
			formatValueToModel(value) {
				if (value != null && this.schema.valueOn) {
					if (value)
						return this.schema.valueOn;
					else
						return this.schema.valueOff;
				}
				return value;
			}		
		}
	}
</script>
