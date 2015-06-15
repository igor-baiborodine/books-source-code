package com.packtpub.vaadin.widget.client.tristatecheckbox;

import com.vaadin.shared.communication.ServerRpc;

public interface TriStateCheckboxServerRpc extends ServerRpc {

  void valueChanged(boolean value);

}
