import {Vue, Component} from 'vue-property-decorator';
import {sharedState} from '../../../store';

@Component({
    template: require('./register.html')
})
export class Register extends Vue {
    sharedState = sharedState;

    submit($event) {
        console.log(this.sharedState);
        $event.preventDefault();
    }
}
