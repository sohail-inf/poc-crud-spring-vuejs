<template>
    <div class="container">
        <h2 class="text-center">Practice</h2>
        <p>{{message}}</p>
        <button v-on:click="reverseMessage">Reverse</button>
        <input v-model="message" />
        <span v-if="!seen">Now you see me</span>
    </div>
    
</template>

<script>

export default {
    name: 'Practice',
    data() {
        return {
            message: 'Hello Vue.js!',
            seen: true,
            name: 'Sohail'
        }
    },
    methods: {
        reverseMessage() {
            this.message = this.message.split('').reverse().join('')
        },
        updateName(newname){
            this.name = newname;
        }
    }
}

</script>

<style>

</style>
