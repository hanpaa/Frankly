<template>
  <vueper-slides
    class="no-shadow"
    :visible-slides="1"
    :arrows="false"
    :gap="13"
    :dragging-distance="15"
    :bullets="false"
    :slideImageInside="true"
  >
    <vueper-slide v-for="(slide, i) in slides"
                  :key="i"
                  :image="slide.image"
                  v-on:click="goLink(slide.link)"/>
  </vueper-slides>
</template>

<script>
import { VueperSlides, VueperSlide } from 'vueperslides';
import 'vueperslides/dist/vueperslides.css';
export default {
  name: 'HomeSlider',
  components: {
    'VueperSlides': VueperSlides,
    'VueperSlide': VueperSlide,
  },
  data: () => ({
    slides: [
      // { image: require('@/assets/slide3.jpg'),
      //   link: 'https://museum.assembly.go.kr/museum/ehbt/ehbt/detail.do?menuNo=700012&pgmMgSn=31'},
      { image: require('@/assets/slide1.png'),
        link: 'https://www.youtube.com/watch?v=hZ3frrjZu-o'},
      { image: require('@/assets/slide2.png'),
        link: 'https://museum.assembly.go.kr/'},
      { image: require('@/assets/slide4.png'),
        link: 'https://www.naon.go.kr/content/html/2022/11/16/21a39867-7f4a-430e-ad1c-0a75a280dc71.html'},
    ]
  }),
  methods:{
    goLink(link){
      window.open(link)
    }
  }
}
</script>

<style>
.vueper-slides {
  padding: 8px 24px;
}
.vueperslides__track-inner{
  padding-left: 15px;
  width: 100%;
  height: 100%;
}
.vueperslide {
  top: 10px;
  background: #FFFFFF;
  box-shadow: 0px 2px 14px rgba(0, 0, 0, 0.12);
  height: 100%;
  width: 100%;
  margin: auto;
}

.vueperslides__bullet .default {
  background-color: rgba(0, 0, 0, 0.3);
  border: none;
  box-shadow: none;
  transition: 0.3s;
  width: 16px;
  height: 16px;
}

.vueperslides__bullet--active .default {background-color: #42b983;}

.vueperslides__bullet span {
  display: block;
  color: #fff;
  font-size: 10px;
  opacity: 0.8;
}
</style>
