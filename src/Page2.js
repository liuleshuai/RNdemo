import React, {Component} from 'react';
import {DeviceEventEmitter, Platform, StyleSheet, Text, View, Button} from 'react-native';
import CommonModule from '../module'

export default class Page2 extends Component {
  constructor(props){
    super(props);
    this.state = {
      msg: "",
    };
  }

  componentWillMount() {
    DeviceEventEmitter.addListener('nativeCallRn', (msg) => {
      // handle event.
      this.setState({
        msg: "接收到原生信息",
      })
    });
  }
  
  render() {
    let {data} = this.props;
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>{data}</Text>
        <Button style = {styles.welcome} onPress = {() => CommonModule.show("RN调用原生方法吐司!", CommonModule.LONG)} title="Native吐司"/>
        <Text style={styles.welcome}>{this.state.msg}</Text>
      </View>
    );   
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#003300',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    color: '#ffffff',
    margin: 10,
  },
});
