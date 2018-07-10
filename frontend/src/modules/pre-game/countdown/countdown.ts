import axios from 'axios';
import {Vue, Component} from 'vue-property-decorator';
import {sharedState} from '../../../store';
import './countdown.scss';

@Component({
    template: require('./countdown.html')
})
export class Countdown extends Vue {
    sharedState = sharedState;
    counter = 10;
    interval;
    isWaiting = this.sharedState.isWaiting;

    mounted() {
        this.getOpponents();
    }

    getOpponents() {
        console.log('getOpponents');
        // axios
    }

    toggleWaiting() {
        this.isWaiting = !this.isWaiting;

        if (!this.isWaiting) {
            this.startCountdown();
        }
    }

    startCountdown() {
        this.interval = setInterval(() => {
            this.timerCount(this.counter);
        }, 1000);
    }

    timerCount(counter) {
        if (counter === 0) {
            clearInterval(this.interval);
            this.counter = 10;
        } else {
            this.counter--;
        }
        console.log(counter);
    }
}
