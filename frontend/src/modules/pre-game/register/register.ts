import {Vue, Component} from 'vue-property-decorator';
import axios from 'axios';
import {sharedState} from '../../../store';
import './register.scss';

@Component({
    template: require('./register.html')
})
export class Register extends Vue {
    sharedState = sharedState;

    submit($event) {
        axios.post(`http://18.185.66.104:4567/register/${sharedState.name}`, {})
            .then(() => {
                this.$router.push({name: 'countdown'});
            });
        $event.preventDefault();
    }
}
